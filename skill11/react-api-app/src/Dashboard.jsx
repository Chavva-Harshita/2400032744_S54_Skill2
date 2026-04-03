import { useState } from 'react';
import LocalUserList from './LocalUserList';
import UserList from './UserList';
import FakePostList from './FakePostList';

const Dashboard = () => {
  const [activeTab, setActiveTab] = useState('local');

  const renderContent = () => {
    switch (activeTab) {
      case 'local':
        return <LocalUserList />;
      case 'api':
        return <UserList />;
      case 'fake':
        return <FakePostList />;
      default:
        return null;
    }
  };

  return (
    <div className="dashboard">
      <header className="dashboard-header">
        <h1>React API Dashboard</h1>
        <nav className="nav-tabs">
          <button 
            className={activeTab === 'local' ? 'active' : ''} 
            onClick={() => setActiveTab('local')}
          >
            Local Users
          </button>
          <button 
            className={activeTab === 'api' ? 'active' : ''} 
            onClick={() => setActiveTab('api')}
          >
            Users API
          </button>
          <button 
            className={activeTab === 'fake' ? 'active' : ''} 
            onClick={() => setActiveTab('fake')}
          >
            Fake API Products
          </button>
        </nav>
      </header>
      <main className="dashboard-content">
        {renderContent()}
      </main>
    </div>
  );
};

export default Dashboard;

