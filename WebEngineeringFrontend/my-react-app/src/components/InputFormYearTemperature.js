import { useState } from "react";

function InputFormYearTemperature(props) {

    const[year, setYear] = useState();

    const getData = (event)=> {
        event.preventDefault();
        fetch("http://localhost:8080/continents/" + year + "/temperature")
            .then(response => response.json())
            .then(json => props.setData(json))
            .catch(error => console.error('Error fetching data:', error));
    }

    const changeYear = event => {
        setYear(event.target.value);
    }

    return (
        <form className="country-form-temperature flex" onSubmit={getData}>
            <label className="label flex" htmlFor="year">
                Year
            </label>
            <input type="text" id="year" name="year" placeholder="Enter year" value={year} onChange={changeYear}></input>
            <button type="submit" className="submit-button">Retrieve</button>
        </form>
    );
}

export default InputFormYearTemperature;