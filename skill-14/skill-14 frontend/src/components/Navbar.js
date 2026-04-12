import React from "react";
import { Link, useNavigate } from "react-router-dom";

function Navbar() {

  const navigate = useNavigate();

  const logout = () => {

    localStorage.removeItem("username");

    navigate("/");

  };

  return (

    <nav style={{ background: "#333", padding: "10px" }}>

      <Link to="/home" style={{ color: "white", marginRight: "15px" }}>
        Home
      </Link>

      <Link to="/profile" style={{ color: "white", marginRight: "15px" }}>
        Profile
      </Link>

      <button onClick={logout}>
        Logout
      </button>

    </nav>

  );

}

export default Navbar;