import React, { useState } from "react";
import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";
import "./App.css";

function App() {
  const [editingStudent, setEditingStudent] = useState(null);

  const refresh = () => {
    setEditingStudent(null);
  };

  return (
    <div className="App">
      <h1> Student Management System</h1>
      <AddStudent editingStudent={editingStudent} onSuccess={refresh} />
      <StudentList onEdit={setEditingStudent} />
    </div>
  );
}

export default App;