import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../styles/profile.css";

const Profile = () => {
  const navigate = useNavigate();
  const [isEditing, setIsEditing] = useState(false);

  const [user, setUser] = useState({
    firstName: "Mavis",
    lastName: "Izumi",
    email: "mavisizumi@gamil.com",
    birthDate: "2025-11-17",
    role: "Information Technology"
  });

  const handleSave = (e) => {
    e.preventDefault();
    setIsEditing(false);
  };

  return (
    <div className="profile-page">
      <div className="profile-content">
        {/* User Identity Section - Now the main focus */}
        <div className="user-identity-box">
          <div className="avatar-container">
            <div className="avatar-placeholder">👤</div>
            <button className="edit-avatar-badge">✏️</button>
          </div>
          <div className="identity-info">
            <h2>{user.firstName} {user.lastName}</h2>
            <p className="user-email-sub">{user.email}</p>
            <p className="user-role-sub">{user.role}</p>
          </div>
        </div>

        {/* Profile Details Card */}
        <div className="profile-details-card">
          <div className="card-top-bar">
            <h3>Profile Details</h3>
            {!isEditing && (
              <button className="btn-edit-toggle" onClick={() => setIsEditing(true)}>
                Edit ✏️
              </button>
            )}
          </div>

          <div className="card-inner-body">
            <p className="form-instruction">Update your personal details.</p>
            <h4 className="section-title">PERSONAL INFORMATION</h4>
            
            <form className="details-form" onSubmit={handleSave}>
              <div className="form-grid">
                <div className="input-group-field">
                  <label>First Name *</label>
                  <input 
                    type="text" 
                    value={user.firstName} 
                    onChange={(e) => setUser({...user, firstName: e.target.value})}
                    disabled={!isEditing}
                  />
                </div>
                
                <div className="input-group-field">
                  <label>Last Name *</label>
                  <input 
                    type="text" 
                    value={user.lastName} 
                    onChange={(e) => setUser({...user, lastName: e.target.value})}
                    disabled={!isEditing}
                  />
                </div>

                <div className="input-group-field">
                  <label>Email *</label>
                  <input 
                    type="email" 
                    value={user.email} 
                    onChange={(e) => setUser({...user, email: e.target.value})}
                    disabled={!isEditing}
                  />
                </div>

                <div className="input-group-field">
                  <label>Birth Date *</label>
                  <input 
                    type="date" 
                    value={user.birthDate} 
                    onChange={(e) => setUser({...user, birthDate: e.target.value})}
                    disabled={!isEditing}
                  />
                </div>
              </div>

              {isEditing && (
                <div className="form-save-actions">
                  <button type="button" className="btn-cancel-flat" onClick={() => setIsEditing(false)}>Cancel</button>
                  <button type="submit" className="btn-save-maroon">Save Changes</button>
                </div>
              )}
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Profile;