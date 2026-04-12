import { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ refresh, editData, setEditData }) {

  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  useEffect(() => {
    if (editData) {
      setStudent(editData);
    }
  }, [editData]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (editData) {
      await axios.put(`http://localhost:9090/students/${editData.id}`, student);
      setEditData(null);
    } else {
      await axios.post("http://localhost:9090/students", student);
    }

    setStudent({ name: "", email: "", course: "" });
    refresh();
  };

  return (
    <div>
      <h3>{editData ? "Update Student" : "Add Student"}</h3>

      <form onSubmit={handleSubmit}>
        <input
          name="name"
          value={student.name}
          onChange={handleChange}
          placeholder="Name"
          required
        />
        <br />

        <input
          name="email"
          value={student.email}
          onChange={handleChange}
          placeholder="Email"
          required
        />
        <br />

        <input
          name="course"
          value={student.course}
          onChange={handleChange}
          placeholder="Course"
          required
        />
        <br />

        <button type="submit">
          {editData ? "Update" : "Add"}
        </button>
      </form>
    </div>
  );
}

export default AddStudent;