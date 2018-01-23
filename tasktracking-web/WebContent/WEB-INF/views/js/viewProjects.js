class ProjectList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {projectArray: []};
    }

    componentDidMount() {
        axios
            .get('http://localhost:8080/project')
            .then(res => this.setState({ projectArray: res.data.projects}))
            .catch(err => console.log(err))
    }

    render() {
        const arrayItems = this.state.projectArray.map((project) =>
            <li key={project.id}>
                {project.name}
            </li>
        );
        return (
            <ul>
                {arrayItems}
            </ul>
        )
    }
}

ReactDOM.render(
    <ProjectList />,
    document.getElementById('root')
);