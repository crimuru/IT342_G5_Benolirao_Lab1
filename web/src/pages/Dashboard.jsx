import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../styles/dashboard.css";

const AchievementCard = ({ item, onDelete }) => {
  const navigate = useNavigate();

  return (
    <div className="milestone-card">
      <div className="milestone-icon-area">
        <div className="milestone-badge">🏆</div>
        {/* Added ?. for extra safety against undefined data */}
        <span className="milestone-date-tag">{item?.date}</span>
      </div>
      <div className="milestone-info">
        <h3>{item?.title}</h3>
        <p>{item?.description}</p>
        <div className="card-controls">
          <button 
            className="btn-edit-small" 
            onClick={() => navigate(`/edit/${item.id}`, { state: { achievement: item } })}
          >
            Edit
          </button>
          <button 
            className="btn-delete-small" 
            onClick={() => onDelete(item.id)}
          >
            Delete
          </button>
        </div>
      </div>
    </div>
  );
};

const Dashboard = () => {
  const navigate = useNavigate();
  
  // State for milestones
  const [milestones, setMilestones] = useState([
    { id: 1, title: "First 10km Run", date: "2026-02-01", description: "Completed in 55 minutes at the local park." },
    { id: 2, title: "React Certification", date: "2026-01-15", description: "Passed the advanced hooks and state management exam." },
    { id: 3, title: "Read 5 Books", date: "2026-01-10", description: "Finished the monthly reading goal ahead of schedule." },
  ]);

  // Handle Delete Function
  const handleDelete = (id) => {
    const updatedMilestones = milestones.filter(m => m.id !== id);
    setMilestones(updatedMilestones);
  };

  return (
    <div className="dashboard-page">
      <div className="dashboard-wrapper">
        <header className="dashboard-header">
          <div className="header-left">
            <h1>My <span className="highlight">Achievements</span></h1>
            <p>You have recorded {milestones.length} personal milestones.</p>
          </div>
          <button className="btn-add-maroon" onClick={() => navigate("/add")}>
            + Add Achievement
          </button>
        </header>

        <section className="achievement-grid">
          {milestones.map((item) => (
            <AchievementCard 
              key={item.id} 
              item={item} // FIXED: matched with the prop name in AchievementCard
              onDelete={handleDelete} 
            />
          ))}
        </section>
      </div>
    </div>
  );
};

export default Dashboard;