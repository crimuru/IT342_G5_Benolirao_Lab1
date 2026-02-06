import axios from 'axios';

const API_URL = "http://localhost:8080/api/auth";

export const register = async (userData) => {
    return await axios.post(`${API_URL}/register`, userData);
};

export const login = async (credentials) => {
    return await axios.post(`${API_URL}/login`, credentials);
};

export const getMe = async () => {
    return await axios.get("http://localhost:8080/api/user/me");
};