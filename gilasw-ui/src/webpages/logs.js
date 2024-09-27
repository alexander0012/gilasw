import React, {useEffect, useState} from 'react';
const Logs = () => {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [logs, setLogs] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/logNotification/all")
            .then(res => res.json())
            .then(
                (data) => {
                    setIsLoaded(true);
                    setLogs(data);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
      }, [])

    if (error) {
        return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        return (
            <ul>
                {logs.map(log => (
                <li key={log.logNotificationGuid}>
                    {log.notification.message} - {log.user.name}
                </li>
                ))}
            </ul>
        );
    }
}
export default Logs;