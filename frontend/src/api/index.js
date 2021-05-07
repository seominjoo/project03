import axios from "axios";

export default axios.create({
    baseURL: "/fleamarket",
    headers: {
        "Content-type": "application/json",
    }
});