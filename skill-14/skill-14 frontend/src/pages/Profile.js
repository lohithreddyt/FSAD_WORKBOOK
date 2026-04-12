import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getUserProfile } from "../services/api";

function Profile() {

  const navigate = useNavigate();

  const [user, setUser] = useState({
    username: "",
    email: ""
  });

  useEffect(() => {

    const username =
      localStorage.getItem("username");

    if (!username) {

      navigate("/");

      return;
    }

    fetchUser(username);

  }, [navigate]);

  const fetchUser = async (username) => {

    try {

      const response =
        await getUserProfile(username);

      setUser(response.data);

    } catch (error) {

      alert("Failed to load profile");

    }

  };

  return (

    <div style={{ padding: "20px" }}>

      <h2>Profile Page</h2>

      <p>
        <strong>Username:</strong>
        {user.username}
      </p>

      <p>
        <strong>Email:</strong>
        {user.email}
      </p>

    </div>

  );

}

export default Profile;