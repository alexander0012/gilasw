import React, {useState} from 'react';
const Notification = () => {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [notification, setNotification] = useState([]);
    const [text, setText] = useState('Message');
    const [category, setCategory] = useState();

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            message: text,
            category: category,
        })
    };

    function sendsMessage () {
        fetch("http://localhost:8080/notification/all", requestOptions)
            .then(res => res.json())
            .then(
                (data) => {
                    setIsLoaded(true);
                    setNotification(data);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }

    if (error) {
        return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        return (
            <>
              <input value={text} onChange={(e) => {setText(e.target.value)}}/>
              <select value={category} onChange={(e) => {
                          setCategory(e.target.value);
                        }}>
                    <option value="Sport">Sports</option>
                    <option value="Finance">Finance</option>
                    <option value="Movies">Movies</option>
              </select>
              <button onClick={sendsMessage}>
                Send Notification
              </button>
              <p>The ID generated: {notification.notificationGuid}</p>
            </>
        );
    }
}
export default Notification;