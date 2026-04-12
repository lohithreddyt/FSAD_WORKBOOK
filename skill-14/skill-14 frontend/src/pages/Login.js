import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { loginUser } from "../services/api";

function Login() {

  const navigate = useNavigate();

  const [user, setUser] = useState({
    username: "",
    password: ""
  });

  const handleChange = (e) => {

    setUser({
      ...user,
      [e.target.name]: e.target.value
    });

  };

  const handleSubmit = async (e) => {

    e.preventDefault();

    try {

      const response = await loginUser(user);

      if (response.data) {

        localStorage.setItem(
          "username",
          response.data.username
        );

        alert("Login Successful");

        navigate("/home");

      } else {

        alert("Invalid Credentials");

      }

    } catch (error) {

      alert("Login Failed");

    }

  };

  return (

    <div style={{ padding: "20px" }}>

      <h2>Login</h2>

      <form onSubmit={handleSubmit}>

        <input
          type="text"
          name="username"
          placeholder="Enter Username"
          onChange={handleChange}
          required
        />

        <br /><br />

        <input
          type="password"
          name="password"
          placeholder="Enter Password"
          onChange={handleChange}
          required
        />

        <br /><br />

        <button type="submit">
          Login
        </button>

      </form>

      <p>
        Don't have account?
        <Link to="/register">
          Register Here
        </Link>
      </p>

    </div>

  );

}

export default Login;