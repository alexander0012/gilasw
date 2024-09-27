import React from 'react';
import {
    BrowserRouter as Router,
    Route,
    Routes,
} from "react-router-dom";

import Logs from './logs';
import Users from './user';
import Notification from './notification';
const Webpages = () => {
    return(
        <Router>
            <Routes>
                <Route exact path="/logs" element={<Logs/>} />
                <Route exact path="/notification" element={<Notification/>} />
                <Route path = "/user" element={<Users/>} />
            </Routes>
        </Router>
    );
};
export default Webpages;