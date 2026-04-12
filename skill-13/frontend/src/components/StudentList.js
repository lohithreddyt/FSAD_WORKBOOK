import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ onEdit }) {
  const [students, setStudents] = useState([]);

  const fetchStudents = () => {
    axios.get("http://localhost:8082/students")
      .then(res => setStudents(res.data))
      .catch(err => console.error("Error fetching students:", err));
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8082/students/${id}`)
      .then(() => fetchStudents())
      .catch(err => console.error("Error deleting student:", err));
  };

  return (
    <div>
      <h2>Student List</h2>
      <table>
        <thead>
          <tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Actions</th></tr>
        </thead>
        <tbody>
          {students.map(s => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.name}</td>
              <td>{s.email}</td>
              <td>{s.course}</td>
              <td>
                <button onClick={() => onEdit(s)}>Update</button>
                <button onClick={() => deleteStudent(s.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;