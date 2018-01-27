class App extends React.Component {
    constructor(props) {
        super(props);
        let iTask = {id: null, name: null, title: null,
            project: {id: null, name: null, tasks: []},
            taskStatus: {id: null, name: null},
            comments: {id: null, text: null, date: null,
                user: {id: null, name: null, mail: null, password: null, role: {id: null, name: null}}}};
        this.state = {task: iTask};
    }

    loadFromServer() {
        axios
            .get('http://localhost:8080/task/'+localStorage.getItem('taskId'))
            .then(res => this.setState({ task: res.data})
                .catch(err => console.log(err)));
    }

    componentDidMount() {
        this.loadFromServer();
    }

    render() {
        return (
            <div>
                <Task task={this.state.task}/>
            </div>
        )
    }
}

class Task extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        console.log(this.props.task.title);
        return (
            <div>

            </div>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('root')
);