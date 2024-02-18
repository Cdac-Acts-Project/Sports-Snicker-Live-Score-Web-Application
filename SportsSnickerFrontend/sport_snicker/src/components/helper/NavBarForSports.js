import React from "react";
import { Link } from "react-router-dom";
import SportSnickerAnimation from "../animation/SportSnickerAnimation";

const NavBarForSports = (props) => {

    const handleLogout = () => {
        localStorage.removeItem("jwtToken");
    }

    return <>
      <nav className="navbar navbar-expand-lg shadow-md py-2 bg-white relative flex items-center w-full justify-between">
        <div className="px-6 w-full flex flex-wrap items-center justify-between">
          <div className="flex items-center">
            <Link to={"/"} className="navbar-brand text-blue-600">
              <svg
                className="w-5 h-5 ml-2 lg:ml-0 mr-2"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 576 512"
              >
                <path
                  fill="currentColor"
                  d="M485.5 0L576 160H474.9L405.7 0h79.8zm-128 0l69.2 160H149.3L218.5 0h139zm-267 0h79.8l-69.2 160H0L90.5 0zM0 192h100.7l123 251.7c1.5 3.1-2.7 5.9-5 3.3L0 192zm148.2 0h279.6l-137 318.2c-1 2.4-4.5 2.4-5.5 0L148.2 192zm204.1 251.7l123-251.7H576L357.3 446.9c-2.3 2.7-6.5-.1-5-3.2z"
                ></path>
              </svg>
            </Link>
          </div>
          <div className="flex items-center lg:ml-auto">
            <SportSnickerAnimation />
          </div>
          <div className="flex items-center lg:ml-auto gap-3">
            <Link
              to={`/${props.pathName}`}
              className="inline-block px-6 py-2.5 bg-blue-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out"
              data-mdb-ripple="true"
              data-mdb-ripple-color="light"
            >
              {props.path}
            </Link>

            <Link
              to={`/${props.pathName1}`}
              className="inline-block px-6 py-2.5 bg-red-700 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-red-700	hover:shadow-lg focus:bg-red-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-red-800 active:shadow-lg transition duration-150 ease-in-out"
              data-mdb-ripple="true"
              data-mdb-ripple-color="light"
              onClick={handleLogout} 
              replace={true}
            >
              {props.path1}
            </Link>
          </div>

        </div>
      </nav>
    </>
}

export default NavBarForSports;