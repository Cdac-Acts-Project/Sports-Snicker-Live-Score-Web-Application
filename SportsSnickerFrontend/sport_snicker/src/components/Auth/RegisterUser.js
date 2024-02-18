import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import NavBar from "../helper/NavBar";
import Background from "../helper/Background";
import RegisterUserAnimation from "../animation/RegisterUserAnimation";

const RegisterUser = () => {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    first_name: "",
    last_name: "",
    email: "",
    password: "",
  });
  const submitData = async () => {
    const res = await axios
      .post("http://localhost:8081/sign-up", user)
      .then((response) => {
        console.log(response);
        localStorage.setItem("first_name",response.data.first_name);
        localStorage.setItem("last_name",response.data.last_name);
        navigate("/login");
      })
      .catch((e) => console.log(e));
    console.log(res);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    submitData();

    setUser({
      ...user,
      first_name: "",
      last_name: "",
      email: "",
      password: "",
    });
  };

  return (
    <>
      <NavBar path="Login" pathName="login"/>
      <Background  />
      <div className="min-w-screen min-h-screen  flex items-center justify-center px-5 py-4">
        <div
          className="bg-gray-100 text-gray-500 rounded-3xl shadow-xl w-full overflow-hidden"
          style={{ maxWidth: "1000px" }}
        >
          <div className="md:flex w-full">
            <div className="w-full md:w-full py-10 px-5 md:px-10">
              <div className="text-center mb-10">
                <h1 className="font-bold text-3xl text-gray-900">Sign up for Live Action</h1>
                {/* <p>Enter your information to register</p> */}
                <RegisterUserAnimation/>
              </div>
              <form onSubmit={handleSubmit}>
                <div>
                  <div className="flex -mx-3">
                    <div className="w-1/2 px-3 mb-5">
                      <label
                        htmlFor="first_name"
                        className="text-xs font-semibold px-1"
                      >
                        First name
                      </label>
                      <div className="flex">
                        <div className="w-10 z-10 pl-1 text-center pointer-events-none flex items-center justify-center">
                          <i className="mdi mdi-account-outline text-gray-400 text-lg"></i>
                        </div>
                        <input
                          type="text"
                          id="first_name"
                          name="first_name"
                          value={user.first_name}
                          className="w-full -ml-10 pl-10 pr-3 py-2 rounded-lg border-2 border-gray-200 outline-none focus:border-blue-600"
                          placeholder="John"
                          onChange={(e) =>
                            setUser({
                              ...user,
                              first_name: e.target.value,
                            })
                          }
                        />
                      </div>
                    </div>
                    <div className="w-1/2 px-3 mb-5">
                      <label
                        htmlFor="last_name"
                        className="text-xs font-semibold px-1"
                      >
                        Last name
                      </label>
                      <div className="flex">
                        <div className="w-10 z-10 pl-1 text-center pointer-events-none flex items-center justify-center">
                          <i className="mdi mdi-account-outline text-gray-400 text-lg"></i>
                        </div>
                        <input
                          type="text"
                          id="last_name"
                          name="last_name"
                          value={user.last_name}
                          className="w-full -ml-10 pl-10 pr-3 py-2 rounded-lg border-2 border-gray-200 outline-none focus:border-blue-600"
                          placeholder="Smith"
                          onChange={(e) =>
                            setUser({
                              ...user,
                              last_name: e.target.value,
                            })
                          }
                        />
                      </div>
                    </div>
                  </div>
                  <div className="flex -mx-3">
                    <div className="w-full px-3 mb-5">
                      <label
                        htmlFor="email"
                        className="text-xs font-semibold px-1"
                      >
                        Email
                      </label>
                      <div className="flex">
                        <div className="w-10 z-10 pl-1 text-center pointer-events-none flex items-center justify-center">
                          <i className="mdi mdi-email-outline text-gray-400 text-lg"></i>
                        </div>
                        <input
                          type="email"
                          id="email"
                          name="email"
                          value={user.email}
                          className="w-full -ml-10 pl-10 pr-3 py-2 rounded-lg border-2 border-gray-200 outline-none focus:border-blue-600"
                          placeholder="johnsmith@example.com"
                          onChange={(e) =>
                            setUser({
                              ...user,
                              email: e.target.value,
                            })
                          }
                        />
                      </div>
                    </div>
                  </div>
                  <div className="flex -mx-3">
                    <div className="w-full px-3 mb-12">
                      <label
                        htmlFor="password"
                        className="text-xs font-semibold px-1"
                      >
                        Password
                      </label>
                      <div className="flex">
                        <div className="w-10 z-10 pl-1 text-center pointer-events-none flex items-center justify-center">
                          <i className="mdi mdi-lock-outline text-gray-400 text-lg"></i>
                        </div>
                        <input
                          type="password"
                          id="password"
                          name="password"
                          value={user.password}
                          onChange={(e) =>
                            setUser({
                              ...user,
                              password: e.target.value,
                            })
                          }
                          className="w-full -ml-10 pl-10 pr-3 py-2 rounded-lg border-2 border-gray-200 outline-none focus:border-blue-600"
                          placeholder="************"
                        />
                      </div>
                    </div>
                  </div>
                  <div className="flex -mx-3">
                    <div className="w-full px-3 mb-5">
                      <button
                        className="block w-full max-w-xs mx-auto bg-blue-600 hover:bg-blue-700 text-white rounded-lg px-3 py-3 font-semibold"
                      >
                        REGISTER NOW
                      </button>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default RegisterUser;
