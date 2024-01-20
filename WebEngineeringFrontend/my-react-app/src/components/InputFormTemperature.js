function InputFormTemperature() {

    const getData = (event)=> {
        event.preventDefault();
        fetch("http://localhost:8080/continents/temperature")
            .then(response => response.json())
            .then(json => localStorage.setItem("results", JSON.stringify(json)))
            .then(() => window.location.href = "results")
            .catch(error => console.error('Error fetching data:', error));
    }

    return (
        <button type="submit" className="submit-button" onClick={getData}>Retrieve</button>
    );
}

export default InputFormTemperature;