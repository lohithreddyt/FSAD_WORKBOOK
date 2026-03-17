import { useState } from 'react'
import './App.css'

function StudentManager() {
  const [students, setStudents] = useState([
    { id: 'S101', name: 'Aisha Khan', course: 'Mathematics' },
    { id: 'S102', name: 'Rohan Patel', course: 'Computer Science' },
    { id: 'S103', name: 'Maya Singh', course: 'Physics' },
    { id: 'S104', name: 'Ishaan Roy', course: 'Chemistry' },
    { id: 'S105', name: 'Leah Nair', course: 'English' },
  ])

  const [newStudent, setNewStudent] = useState({ id: '', name: '', course: '' })

  const handleInputChange = (e) => {
    const { name, value } = e.target
    setNewStudent((prev) => ({ ...prev, [name]: value }))
  }

  const addStudent = () => {
    const trimmedId = newStudent.id.trim()
    const trimmedName = newStudent.name.trim()
    const trimmedCourse = newStudent.course.trim()
    if (!trimmedId || !trimmedName || !trimmedCourse) {
      return
    }

    setStudents((prev) => [
      ...prev,
      { id: trimmedId, name: trimmedName, course: trimmedCourse },
    ])
    setNewStudent({ id: '', name: '', course: '' })
  }

  const deleteStudent = (idToDelete) => {
    setStudents((prev) => prev.filter((student) => student.id !== idToDelete))
  }

  return (
    <div className="app-shell">
      <div className="card">
        <h1>Student Manager</h1>
        <p>
          Add, list, and delete students dynamically using React <code>useState</code>.
        </p>

        <div className="form-row">
          <div className="field">
            <label htmlFor="student-id">ID</label>
            <input
              id="student-id"
              name="id"
              value={newStudent.id}
              onChange={handleInputChange}
              placeholder="e.g. S106"
            />
          </div>
          <div className="field">
            <label htmlFor="student-name">Name</label>
            <input
              id="student-name"
              name="name"
              value={newStudent.name}
              onChange={handleInputChange}
              placeholder="Enter name"
            />
          </div>
          <div className="field">
            <label htmlFor="student-course">Course</label>
            <input
              id="student-course"
              name="course"
              value={newStudent.course}
              onChange={handleInputChange}
              placeholder="Enter course"
            />
          </div>
        </div>

        <div className="actions">
          <button type="button" onClick={addStudent} className="add-btn">
            Add Student
          </button>
        </div>

        {students.length === 0 ? (
          <div className="empty">No students available</div>
        ) : (
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {students.map((student) => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>{student.course}</td>
                  <td>
                    <button
                      type="button"
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
    </div>
  )
}

function App() {
  return <StudentManager />
}

export default App
