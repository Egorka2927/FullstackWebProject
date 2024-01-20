function WebFormBig(props) {
    return (
        <div className="menu-container create-menu">
            <h2>{props.header}</h2>
            <form onSubmit={props.handleSubmit} className="country-form flex">
                <label htmlFor="country">Country name or code</label>
                <input type="text" id="country" name="country" value={props.country} onChange={props.changeCountry} placeholder="Enter country"/>
                <label htmlFor="population">Population</label>
                <input type="text" id="population" name="population" value={props.population} onChange={props.changePopulation} placeholder="Enter value"/>
                <label htmlFor="gdp">Gdp</label>
                <input type="text" id="gdp" name="gdp" value={props.gdp} onChange={props.changeGdp} placeholder="Enter value"/>
                <label htmlFor="year">Year</label>
                <input className="last-input" type="text" id="year" name="year" value={props.year} onChange={props.changeYear} placeholder="Enter year"/>
                <button type="submit" className="submit-button">
                    {props.button}
                </button>
            </form>
        </div>
    )
}

export default WebFormBig;