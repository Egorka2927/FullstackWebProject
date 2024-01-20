function NavBar() {
    return (
        <div className="nav">
            <ul className="links-list flex">
                <li>
                    <a href="/" className="menu-link">
                        Home
                    </a>
                </li>
                <li>
                    <a href="/popGdp" className="menu-link">
                        Population and gdp data
                    </a>
                </li>
                <li>
                    <a href="/emissions" className="menu-link">
                        Emissions data
                    </a>
                </li>
                <li>
                    <a href="/energyGdp" className="menu-link">
                        Energy and gdp data
                    </a>
                </li>
                <li>
                    <a href="/temperature" className="menu-link">
                        Temperature data
                    </a>
                </li>
                <li>
                    <a href="/countries" className="menu-link">
                        Countries data
                    </a>
                </li>
            </ul>
        </div>
    );
}

export default NavBar;