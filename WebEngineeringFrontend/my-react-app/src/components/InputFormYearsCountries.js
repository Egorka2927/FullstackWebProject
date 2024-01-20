import { useState } from "react";

function InputFormYearsCountries(props) {

    const[years, setYears] = useState();
    const[numberCountries, setNumberCountries] = useState();
    const[filter, setFilter] = useState("TOP");

    const getData = (event)=> {
        event.preventDefault();
        if (numberCountries != 0) {
            fetch("http://localhost:8080/countries/names?number_countries=" + numberCountries + "&years=" + years + "&filter=" + filter)
                .then(response => response.json())
                .then(json => props.setData(json))
                .catch(error => console.error('Error fetching data:', error));
        }
    }

    const changeYears = event => {
        setYears(event.target.value);
    }

    const changeNumberCountries = event => {
        setNumberCountries(event.target.value);
    }

    const changeFilter = event => {
        setFilter(event.target.value);
    }

    return (
        <form className="country-form flex" onSubmit={getData}>
            <label className="label flex" htmlFor="years">
                Range
            </label>
            <input type="text" id="years" name="years" placeholder="Enter range" value={years} onChange={changeYears}></input>

            <label className="label flex" htmlFor="numberCountries">
                Number of countries
            </label>
            <input type="text" id="numberCountries" name="numberCountries" placeholder="Enter number" value={numberCountries} onChange={changeNumberCountries}></input>

            <label className="label flex" htmlFor="filter">
                Filter
            </label>
            <select value={filter} onChange={changeFilter}>
                <option value={"TOP"}>Top</option>
                <option value={"BOTTOM"}>Bottom</option>
            </select>

            <button type="submit" className="submit-button">Retrieve</button>
        </form>
    );
}

export default InputFormYearsCountries;