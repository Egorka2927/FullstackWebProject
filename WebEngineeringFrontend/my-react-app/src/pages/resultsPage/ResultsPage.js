function ResultsPage() {
    const data = localStorage.getItem("results");
    const dataParsed = JSON.parse(data);
    let keys;
    let values;
    if (!(dataParsed instanceof Array)) {
        keys = Object.keys(dataParsed);
        values = Object.values(dataParsed);
        return (
            <div className="main-container flex">
                <table>
                    <tr>
                        {keys.map(key => <th>{key.charAt(0).toUpperCase() + key.slice(1)}</th>)}
                    </tr>
                    <tr>
                        {values.map(value => <td>{value}</td>)}
                    </tr>
                </table>
            </div>
        );
    } else {
        if (dataParsed.length === 0) {
            return (
                <div className="main-container flex">
                    <p>Data not found</p>
                </div>
            );
        }
        keys = Object.keys(dataParsed[0]);
        return (
            <div className="main-container flex">
                <table>
                    <tr>
                        {keys.map(key => <th>{key.charAt(0).toUpperCase() + key.slice(1)}</th>)}
                    </tr>
                    {dataParsed.map(element => <tr>{Object.values(element).map(value => value === null ? <td>null</td> : <td>{value}</td>)}</tr>)}
                </table>
            </div>
        );
    }
}

export default ResultsPage;