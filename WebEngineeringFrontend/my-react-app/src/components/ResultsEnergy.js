function ResultsEnergy(props) {
    if (props.create) {
        return <li className="list-element-data">Id: {props.id}</li>
    } else if (props.update) {
        return <li className="list-element-data">Energy per capita: {props.energyPerCapitaUpdate}, Energy per gdp: {props.energyPerGdpUpdate}</li>
    } else if (props.delete) {
        return <li className="list-element-data">Message: {props.message}</li>
    }
}

export default ResultsEnergy;