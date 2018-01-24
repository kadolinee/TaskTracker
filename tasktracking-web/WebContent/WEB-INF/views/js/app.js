class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {projectArray: []};
        this.addProject = this.addProject.bind(this);
    }

    addProject(project) {
        let newProjectArray = this.state.projectArray.concat(project);
        this.setState({projectArray: newProjectArray});
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
                <ProjectList projectArray={this.state.projectArray} />
            </div>
        )
    }

}

class ProjectList extends React.Component {
    render() {
        const arrayItems = this.props.projectArray.map((project) =>
            <li key={project.id}>
                {project.name}
                <TaskList project={project.tasks} />
            </li>

        );
        return (

            <ul className="project">
                {arrayItems}
            </ul>
        )
    }
}



class TaskList extends React.Component {
    render() {
        const arrayItems = this.props.project.map((task) =>
            <li key={task.id}>
                {task.name}
            </li>
        );
        return (
            <ul className="task">
                {arrayItems}
            </ul>
        )
    }
}

class CreateProject extends React.Component {
    constructor(props) {
        super(props);
        this.state = {projectName: ''};
    }

    onFieldChange(e) {
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
            <form onSubmit={this.handleSubmit.bind(this)}>
                <input
                    type='text'
                    onChange={this.onFieldChange.bind(this)} value={this.state.projectName}
                    placeholder='Name of the new project'
                />
                <button>Create</button>
            </form>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('root')
);