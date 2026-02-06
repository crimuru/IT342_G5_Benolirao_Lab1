import React, { useState, useEffect } from "react";
import { useNavigate, useParams, useLocation } from "react-router-dom";
import "../styles/forms.css";

const AchievementForm = () => {
  const navigate = useNavigate();
  const { id } = useParams(); // Used for editing
  const location = useLocation();
  const isEdit = !!id;

  const [formData, setFormData] = useState({
    title: "",
    date: "",
    description: ""
  });

  useEffect(() => {
    if (isEdit && location.state?.achievement) {
      setFormData(location.state.achievement);
    }
  }, [isEdit, location.state]);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Pro Tip: Here you will use axios.post (for new) or axios.put (for edit) to MySQL
    console.log(isEdit ? "Updating..." : "Creating...", formData);
    navigate("/dashboard");
  };

  return (
    <div className="form-page">
      <div className="form-card">
        <h2>{isEdit ? "Edit" : "New"} <span className="highlight">Milestone</span></h2>
        <form onSubmit={handleSubmit} className="milestone-form">
          <div className="input-group">
            <label>Title</label>
            <input 
              type="text" 
              value={formData.title} 
              onChange={(e) => setFormData({...formData, title: e.target.value})} 
              required 
            />
          </div>
          <div className="input-group">
            <label>Date</label>
            <input 
              type="date" 
              value={formData.date} 
              onChange={(e) => setFormData({...formData, date: e.target.value})} 
              required 
            />
          </div>
          <div className="input-group">
            <label>Description</label>
            <textarea 
              rows="4" 
              value={formData.description} 
              onChange={(e) => setFormData({...formData, description: e.target.value})} 
              required 
            />
          </div>
          <div className="form-actions">
            <button type="button" className="btn-cancel" onClick={() => navigate("/dashboard")}>Cancel</button>
            <button type="submit" className="btn-maroon-save">Save Achievement</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AchievementForm;