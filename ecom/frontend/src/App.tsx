import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import AddProduct from './pages/addProduct'

function App() {


  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/addProduct' element={<AddProduct />} />
        
      </Routes>
    </BrowserRouter>
  )
}

export default App
