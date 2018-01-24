class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {projectArray: []};
    }

    loadFromServer() {
        axios
            .get('http://localhost:8080/project')
            .then(res => this.setState({ projectArray: res.data.projects}))
            .catch(err => console.log(err))
    }

    componentDidMount() {
        this.loadFromServer();
    }

    render() {
        return (
            <div>
                <CreateProject />
                <ProjectList projectArray={this.state.projectArray} />
            </div>
        )
    }

}

class ProjectList extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const arrayItems = this.props.projectArray.map((project) =>
            <li key={project.id}>
                {project.name}
            </li>
        );
        return (
            <ul className="project">
                {arrayItems}
            </ul>
        )
    }
}

class CreateProject extends React.Component {
    constructor(props) {
        super(props);
        this.state = {project: ''};
        this.postOnServer = this.postOnServer.bind(this);
    }

    postOnServer(newProject) {
        axios
            .post('http://localhost:8080/project', {
                name: newProject})
            .then(res => console.log(res))
            .catch(err => console.log(err))
    }

    onFieldChange(e) {
        let text = e.target.value;
        this.setState({text: text});
    }

    handleSubmit(e) {
        e.preventDefault();
        let text = this.state.text;
        this.setState({text: ''});
        this.postOnServer(text);
    }

    componentDidMount(newProject) {
        this.postOnServer(newProject);
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit.bind(this)}>
                <input
                    type='text'
                    onChange={this.onFieldChange.bind(this)} value={this.state.text}
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