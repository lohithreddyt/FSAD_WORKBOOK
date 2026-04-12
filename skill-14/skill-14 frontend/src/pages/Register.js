import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { registerUser } from "../services/api";

function Register() {

  const navigate = useNavigate();

  const [user, setUser] = useState({
    username: "",
    email: "",
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

      await registerUser(user);

      alert("Registration Successful");

      navigate("/");

    } catch (error) {

      alert("Registration Failed");

    }

  };

  return (

    <div style={{ padding: "20px" }}>

      <h2>Register</h2>

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
          type="email"
          name="email"
          placeholder="Enter Email"
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
          Register
        </button>

      </form>

    </div>

  );

}

export default Register;