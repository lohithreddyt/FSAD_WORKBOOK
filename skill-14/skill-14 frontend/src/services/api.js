import axios from "axios";

const API_URL = "http://localhost:9090/api/users";

export const registerUser = (userData) => {
  return axios.post(API_URL + "/register", userData);
};

export const loginUser = (userData) => {
  return axios.post(API_URL + "/login", userData);
};

export const getUserProfile = (username) => {
  return axios.get(API_URL + "/" + username);
};