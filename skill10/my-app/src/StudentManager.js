import React, { useState } from 'react';
import './StudentManager.css';

const StudentManager = () => {
  const [students, setStudents] = useState([
    { id: 1, name: 'John Doe', course: 'Mathematics' },
    { id: 2, name: 'Jane Smith', course: 'Physics' },
    { id: 3, name: 'Bob Johnson', course: 'Chemistry' },
    { id: 4, name: 'Alice Brown', course: 'Biology' },
    { id: 5, name: 'Charlie Wilson', course: 'Computer Science' }
  ]);

  const [newStudent, setNewStudent] = useState({ id: '', name: '', course: '' });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewStudent(prev => ({ ...prev, [name]: value }));
  };

  const addStudent = () => {
    const idNum = parseInt(newStudent.id);
    if (isNaN(idNum)) {
      alert('Please enter a valid ID number.');
      return;
    }
    if (students.some(student => student.id === idNum)) {
      alert('ID already exists. Please use a unique ID.');
      return;
    }
    if (newStudent.name && newStudent.course) {
      setStudents([...students, { id: idNum, name: newStudent.name, course: newStudent.course }]);
      setNewStudent({ id: '', name: '', course: '' });
    }
  };

  const deleteStudent = (id) => {
    setStudents(students.filter(student => student.id !== id));
  };

  return (
    <div className="student-manager">
      <h2>Student Manager</h2>
      
      <div className="add-student">
        <input
          type="number"
          name="id"
          placeholder="ID"
          value={newStudent.id}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={newStudent.name}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="course"
          placeholder="Course"
          value={newStudent.course}
          onChange={handleInputChange}
        />
        <button onClick={addStudent}>Add Student</button>
      </div>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table className="students-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map(student => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button 
                    className="delete-btn"
                    onClick={() => deleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default StudentManager;

