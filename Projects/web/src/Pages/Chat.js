import React from 'react';
import Nav from '../Component/Navbar';
import { useState } from 'react';
function Chat(props){
    const [message, setMessage] = useState('');
    const [messages, setMessages] = useState([]);
    const handleSubmit = (e) => {
        e.preventDefault();
        if (message.trim() === '') return;
        setMessages([...messages, { id: messages.length, text: message, isMe: true }]);
        setMessage('');
      };
    
      const handleChange = (e) => {
        setMessage(e.target.value);
      };
      return (
        <div className="chat-background">
        <Nav profile={props.profile} setProfile={props.setProfile}></Nav>
        <div className="chat-container">
          <div className="chat-messages">
            {messages.map((m) => (
              <div key={m.id} className={`message ${m.isMe ? 'me' : ''}`}>
                {m.text}
              </div>
            ))}
          </div>
          <form onSubmit={handleSubmit} className="chat-form">
            <input
              type="text"
              placeholder="Type a message..."
              value={message}
              onChange={handleChange}
            />
            <button type="submit">Send</button>
          </form>
        </div>
        </div>
      );
}
export default Chat;