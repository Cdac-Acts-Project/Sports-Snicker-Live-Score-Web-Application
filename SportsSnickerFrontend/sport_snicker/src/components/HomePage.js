import React from "react";
import { Link } from "react-router-dom";
import HomeTypeAnimation from "./animation/HomeTypeAnimation";
import NavBar from "./helper/NavBar";
import Background from "./helper/Background";

const HomePage = () => {
  return (
    <section className="mb-40">
      <NavBar path="Login" pathName="login"/>
      <Background/>
      <div className="container mx-auto px-6 md:px-12 xl:px-32">
        <div className="text-center text-gray-800">
          <div
            className="block rounded-lg shadow-lg px-6 py-12 md:py-16 md:px-12"
            style={{
              marginTop: "180px",
              backgroundColor: "hsla(0, 0%, 100%, 0.8)",
              backdropFilter: "saturate(200%) blur(25px)",
            }}
          >
            <h1 className="text-5xl md:text-6xl xl:text-3xl font-bold tracking-tight mb-12">
              <span className="text-blue-600 xl:text-7xl">Sports Snicker</span>
              <br />
              <br />
              Your Ultimate Hub for Live Sports Action!
              <br />
              <HomeTypeAnimation />
            </h1>
            <Link
              to={"/sign-up"}
              className="inline-block px-7 py-3 mb-2 md:mb-0 mr-0 md:mr-2 bg-blue-600 text-white font-medium text-sm leading-snug uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out"
              data-mdb-ripple="true"
              data-mdb-ripple-color="light"
              role="button"
            >
              Register Here
            </Link>
          </div>
        </div>
      </div>
    </section>
  );
};

export default HomePage;
