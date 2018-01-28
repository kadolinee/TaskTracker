class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {projectArray: []};
        this.addProject = this.addProject.bind(this);
        this.addTask = this.addTask.bind(this);
    }

    addProject(project) {
        let newProjectArray = this.state.projectArray.concat(project);
        this.setState({projectArray: newProjectArray});
    }

    addTask(projectId, task) {
        // let taskId = null;
        // this.state.projectArray.map(project => {
        //     if (project.id === projectId) {
        //         taskId = project.tasks[projectId.tasks.length];
        //         project.tasks.concat(task);
        //     }
        // });
    }

    loadFromServer() {
        axios
            .get('http://localhost:8080/project')
            .then(res => this.setState({ projectArray: res.data.projects})
            .catch(err => console.log(err)))
    }

    componentDidMount() {
        this.loadFromServer();
    }

    render() {
        return (
            <div>
                <CreateProject addProject={this.addProject} projectArray={this.state.projectArray} />
                <CreateTask addTask={this.addTask} projectArray={this.state.projectArray}/>
                <ProjectList projectArray={this.state.projectArray} />
            </div>
        )
    }

}

class ProjectList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {focused: 0 };
        this.tasksClick = this.tasksClick.bind(this);
    }

    tasksClick(index) {
        this.setState({focused: index});
    }

    render() {
        return (
            <ul className="project">
                {this.props.projectArray.map((project) => {
                    let style = 'none';
                    if (this.state.focused === project.id) {
                        style = '';
                    }

                    return <li key={project.id}>
                        <a href="#" onClick={this.tasksClick.bind(this, project.id)}>{project.name}</a>
                        <TaskList project={project.tasks} style={style}/>
                    </li>;})}
            </ul>
        )
    }
}

class TaskList extends React.Component {
    handleClick(taskId) {
        // Check if the sessionStorage object exists
        localStorage.setItem("taskId", taskId);
    }

    render() {
        let style = this.props.style;
        let arrayItems = [];
        if (style === '') {
         arrayItems = this.props.project.map((task) =>
            <div className={style}>
            <li key={task.id}>
                <a href='/taskPage' onClick={this.handleClick(task.id)}><h3> {task.name} </h3></a>
            </li>
            </div>

        )}
        return (
                <ul>
                    {arrayItems}
                </ul>
        )
    }
}

class CreateProject extends React.Component {
    constructor(props) {
        super(props);
        this.state = {projectName: null};
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(e) {
        let projectName = e.target.value;
        this.setState({projectName: projectName});
    }

    handleSubmit(e) {
        e.preventDefault();
        let projectName = this.state.projectName;
        this.postOnServer(projectName);
        this.setState({projectName: ''});

        let id = this.props.projectArray[this.props.projectArray.length];
        let project = {name: projectName, id: id};
        this.props.addProject(project);
    }

    postOnServer(projectName) {
        axios
            .post('http://localhost:8080/project', {
                name: projectName
            })
            .then(res => console.log(res))
            .catch(err => console.log(err))
    }

    componentDidMount(project) {
        this.postOnServer(project);
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <input
                    type='text'
                    onChange={this.handleChange} value={this.state.projectName}
                    placeholder='Name of the new project'
                />
                <input type="submit" value="Create project"/>
            </form>
        )
    }
}

class CreateTask extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: null, title: null, project: {id: null, name: null}};
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleTitleChange = this.handleTitleChange.bind(this);
        this.handleProjectChange = this.handleProjectChange.bind(this);
        this.handleNameChange = this.handleNameChange.bind(this);
    }

    handleNameChange(e) {
        this.setState({name: e.target.value});
    }

    handleTitleChange(e) {
        this.setState({title: e.target.value});
    }

    handleProjectChange(e) {
        this.setState({project: {id: e.target.value}});
    }

    handleSubmit(e) {
        e.preventDefault();
        let name = this.state.name;
        let title = this.state.title;
        let project = this.state.project;
        let taskStatus = {id: 1, name: ''};
        this.postOnServer(name, title, project, taskStatus);
        this.setState({name: '', title: '', project: {id: 1}});
    }

    postOnServer(name, title, project, taskStatus) {
        axios
            .post('http://localhost:8080/task', {
                name: name,
                taskStatus: taskStatus,
                title: title,
                project: project
            })
            .then(res => console.log(res))
            .catch(err => console.log(err))
    }

    componentDidMount(name, title, project, taskStatus) {
        this.postOnServer(name, title, project, taskStatus);
    }

    render() {
        const projectArray = this.props.projectArray.map(project =>
           <option key={project.id} value={project.id}>
               {project.name}
           </option>
        );
        return (
            <form onSubmit={this.handleSubmit}><br/>
                <label>
                    Task name:
                    <input type="text" value={this.state.name} onChange={this.handleNameChange}/><br/><br/>
                </label>
                <label>
                    Description:
                    <textarea value={this.state.title} onChange={this.handleTitleChange}/><br/><br/>
                </label>
                <label>
                    Pick project:
                    <select value={this.state.project.id} onChange={this.handleProjectChange}>
                        {projectArray}
                    </select>
                </label>
                <input type="submit" value="Create task" />
            </form>
        );
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('root')
);
