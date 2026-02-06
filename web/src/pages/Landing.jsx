import React from "react";
import { useNavigate } from "react-router-dom";
import "../styles/landing.css";

const Landing = () => {
  const navigate = useNavigate();

  return (
    <div className="landing-page">
      {/* Navbar */}
      <nav className="navbar">
        <h1 className="logo">
          <span className="highlight">Milestone</span>Mind
        </h1>
        <div className="nav-buttons">
          <button onClick={() => navigate("/login")} className="btn-text">
            Sign In
          </button>
          <button onClick={() => navigate("/register")} className="btn-primary">
            Start Logging
          </button>
        </div>
      </nav>

      {/* Hero Section */}
      <section className="hero">
        <p className="tagline">Celebrate Every Step of Your Journey</p>
        <h2 className="hero-title">
          Track Your Personal <br /> <span>Achievements & Goals</span>
        </h2>
        <p className="hero-desc">
          Success is a collection of small wins. MilestoneMind allows you to 
          record personal milestones, track long-term goals, and visualize your 
          progress over time—turning your ambitions into a record of success.
        </p>
        <div className="hero-buttons">
          <button className="btn-primary" onClick={() => navigate("/register")}>
            Start Your Log Free
          </button>
          <button className="btn-outline" onClick={() => navigate("/login")}>
            View My History
          </button>
        </div>
      </section>

      {/* Features Section */}
      <section className="features">
        <h3>Designed to Empower Your Growth</h3>
        <p>Simple yet powerful tools to document your path to greatness</p>
        <div className="feature-grid">
          {[
            { title: "Milestone Logging", desc: "Instantly record wins as they happen, from finishing a book to completing a marathon." },
            { title: "Progress Visualization", desc: "See your accomplishments grow through beautiful timelines and interactive charts." },
            { title: "Goal Categorization", desc: "Organize your wins by category: Career, Health, Personal, or Learning." },
            { title: "Smart Reminders", desc: "Stay motivated with gentle nudges to check in on your long-term objectives." },
            { title: "Secure Storage", desc: "Your personal achievements are private and encrypted, safe for your eyes only." },
            { title: "Daily Highlights", desc: "Reflect on your best moments with a daily summary of past accomplishments." },
          ].map((item, i) => (
            <div className="feature-card" key={i}>
              <h4>{item.title}</h4>
              <p>{item.desc}</p>
            </div>
          ))}
        </div>
      </section>

      {/* How It Works */}
      <section className="how-it-works">
        <h3>
          How <span className="highlight">MilestoneMind</span> Works
        </h3>
        <p>Documenting your success has never been easier.</p>
        <div className="steps">
          <div className="step">
            <div className="icon-circle">1</div>
            <h4>Log an Achievement</h4>
            <p>Write down what you accomplished and how it made you feel.</p>
          </div>
          <div className="step">
            <div className="icon-circle">2</div>
            <h4>Categorize & Tag</h4>
            <p>Group your milestones to see which areas of your life are flourishing.</p>
          </div>
          <div className="step">
            <div className="icon-circle">3</div>
            <h4>Reflect & Grow</h4>
            <p>Look back at your journey to gain confidence for your future goals.</p>
          </div>
        </div>
      </section>

      {/* Why Users Love MilestoneMind */}
      <section className="why-love">
        <h3>
          Why Users Love <span className="highlight">MilestoneMind</span>
        </h3>
        <p>Built for those who value progress and self-reflection.</p>
        <div className="reasons">
          <div>
            <h4>📈 Boost Confidence</h4>
            <p>Seeing a physical list of your wins reminds you of what you're capable of.</p>
          </div>
          <div>
            <h4>🧠 Mental Clarity</h4>
            <p>Offload your goals and past wins to keep your mind focused on the present.</p>
          </div>
          <div>
            <h4>🎯 Stay Driven</h4>
            <p>Tracking progress prevents burnout by highlighting how far you've come.</p>
          </div>
          <div>
            <h4>💎 Legacy Building</h4>
            <p>Create a digital journal of your life's most meaningful highlights.</p>
          </div>
        </div>
      </section>
    </div>
  );
};

export default Landing;