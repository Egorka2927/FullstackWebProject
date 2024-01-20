function Results(props) {
    if (props.retrieve) {
        return <li className="list-element-data">Population: {props.populationRetrieve}, Gdp: {props.gdpRetrieve}</li>
    } else if (props.create) {
        return <li className="list-element-data">Id: {props.id}</li>
    } else if (props.update) {
        return <li className="list-element-data">Population: {props.populationUpdate}, Gdp: {props.gdpUpdate}</li>
    } else if (props.delete) {
        return <li className="list-element-data">Message: {props.message}</li>
    }
}

export default Results;