import React, { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ editingStudent, onSuccess }) {
  const [student, setStudent] = useState({ name: "", email: "", course: "" });

  useEffect(() => {
    if (editingStudent) setStudent(editingStudent);
  }, [editingStudent]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (student.id) {
      axios.put(`http://localhost:8082/students/${student.id}`, student)
        .then(() => onSuccess());
    } else {
      axios.post("http://localhost:8082/students", student)
        .then(() => onSuccess());
    }
    setStudent({ name: "", email: "", course: "" });
  };

  return (
    <div>
      <h2>{student.id ? "Update Student" : "Add Student"}</h2>
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={student.name} onChange={handleChange} />
        <input name="email" placeholder="Email" value={student.email} onChange={handleChange} />
        <input name="course" placeholder="Course" value={student.course} onChange={handleChange} />
        <button type="submit">{student.id ? "Update" : "Add"}</button>
      </form>
    </div>
  );
}

export default AddStudent;