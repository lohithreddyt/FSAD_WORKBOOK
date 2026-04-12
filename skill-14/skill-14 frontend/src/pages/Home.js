import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Home() {

  const navigate = useNavigate();

useEffect(() => {

  const username =
    localStorage.getItem("username");

  if (!username) {

    navigate("/");

  }

}, [navigate]);

  return (

    <div style={{ padding: "20px" }}>

      <h2>Welcome to Home Page</h2>

    </div>

  );

}

export default Home;