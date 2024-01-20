function WebFormBigEnergy(props) {
    return (
        <div className="menu-container create-menu">
            <h2>{props.header}</h2>
            <form onSubmit={props.handleSubmit} className="country-form flex">
                <label htmlFor="country">Country name</label>
                <input type="text" id="country" name="country" value={props.country} onChange={props.changeCountry} placeholder="Enter country"/>
                <label htmlFor="energyPerCapita">Energy per capita</label>
                <input type="text" id="energyPerCapita" name="energyPerCapita" value={props.energyPerCapita} onChange={props.changeEnergyPerCapita} placeholder="Enter value"/>
                <label htmlFor="energyPerGdp">Energy per gdp</label>
                <input type="text" id="energyPerGdp" name="energyPerGdp" value={props.energyPerGdp} onChange={props.changeEnergyPerGdp} placeholder="Enter value"/>
                <label htmlFor="year">Year</label>
                <input className="last-input" type="text" id="year" name="year" value={props.year} onChange={props.changeYear} placeholder="Enter year"/>
                <button type="submit" className="submit-button">
                    {props.button}
                </button>
            </form>
        </div>
    )
}

export default WebFormBigEnergy;