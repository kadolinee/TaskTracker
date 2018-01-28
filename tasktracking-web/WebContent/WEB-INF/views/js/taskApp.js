class App extends React.Component {
    constructor(props) {
        super(props);
        let iTask = {id: null, name: null, title: null,
            project: {id: null, name: null, tasks: []},
            taskStatus: {id: null, name: null},
            comments: [{id: null, text: null, date: null,
                user: {id: null, name: null, mail: null, role: {id: null, name: null}}}]};
        this.state = {task: iTask};
    }

    loadFromServer() {
        axios
            .get('http://localhost:8080/task/' + localStorage.getItem('taskId'))
            .then(res => this.setState({ task: res.data})
                .catch(err => console.log(err)));
    }

    componentDidMount() {
        this.loadFromServer();
    }

    render() {
        return (
            <div>
                <ChangeStatus />
                <Task task={this.state.task} />
            </div>
        )
    }
}

class Task extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let comments = this.props.task.comments.map(comment =>
            <div key={comment.id}>
                <p>{comment.text}</p>
                <h3>{comment.date}</h3>
                <h3>{comment.user.name}</h3>
                <br/>
            </div>
        );

        return (
            <div>
            <h1>{this.props.task.name}, {this.props.task.taskStatus.name}</h1>
                <p>{this.props.task.title}</p>
                <br/>
                {comments}
            </div>
        )
    }
}

class ChangeStatus extends React.Component {
    constructor(props) {
        super(props);
        this.state = {taskStatusId: 1};
        this.handleStatusChange = this.handleStatusChange.bind(this);
    }

    handleStatusChange(e) {
        this.setState({taskStatusId: parseInt(e.target.value)});
    }

    handleSubmit(e) {
        e.preventDefault();
        let statusId = this.state.taskStatusId;
        let taskId = localStorage.getItem('taskId');
        this.putOnServer(taskId, statusId);
        this.setState({taskStatusId: 1});
    }

    putOnServer(taskId, statusId) {
        if (taskId !== null && statusId !== null) {
        axios
            .put('http://localhost:8080/task/' + localStorage.getItem('taskId') + '/' + this.state.taskStatusId, {
                taskId: taskId,
                statusId: statusId
            })
            .then(res => console.log(res))
            .catch(err => console.log(err))
        }
    }

    componentDidMount(taskId, statusId) {
        this.putOnServer(taskId, statusId);
    }


    render() {
        return (
            <form onSubmit={this.handleSubmit}><br/>
                <label>
                    <select value={this.state.taskStatusId} onChange={this.handleStatusChange}>
                        <option value='1'>waiting</option>
                        <option value='2'>implementation</option>
                        <option value='3'>verifying</option>
                        <option value='4'>releasing</option>
                    </select>
                </label>
                <input type="submit" value="Change status"/>
            </form>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('root')
);