import {  useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";


export default function AddProduct(){
    let [productName,setProductName] = useState("")
    let [productDec, setProductDec] = useState("")
    let [price, setPrice]  = useState("");
    let [category , setCategory] = useState("cloth");
    let [date,setDate] = useState("");
    let [isAvialable,setIsAvialable] = useState(false);
    let [stockCount, setStockCount] = useState("");
    let [image, setImage] = useState<File | null>(null);
    const fileInputRef = useRef<HTMLInputElement>(null);
    const navigate = useNavigate();


    const HandleSubmit = async (e) => {
        e.preventDefault();
        const formData = new FormData();

        formData.append("productName", productName);
        formData.append("productDescription", productDec);
        formData.append("price", price);
        formData.append("category", category);
        formData.append("releaseDate", date);
        formData.append("isAvialable", String(isAvialable));
        formData.append("stockCount", stockCount);

        if (image) {
            formData.append("image", image);
        }

        console.log(formData)
        try{
            const response = await fetch("http://localhost:8080/addProduct",{
                method:"POST",
                body:formData
            })
            if(!response.ok){
                throw new Error("Failed to add product")
            }
            const data = await response.json();
            console.log(data)
            setProductName("")
            setProductDec("")
            setPrice("")
            setDate("")
            setIsAvialable(false)
            setCategory("cloth");
            setStockCount("")
            setImage(null)
            if(fileInputRef.current){
                fileInputRef.current.value = "";
            }
            navigate("/")
        } catch{
            console.log("server Error")
        }

       
        
    }

  return (
    <div className="bg-light min-vh-100 py-5">
        <div className="container">
            <div className="row justify-content-center">
                <div className="col-12 col-md-10 col-lg-8 col-xl-7">

                    {/* Header */}
                    <div className="d-flex justify-content-between align-items-center mb-4">
                        <div>
                            <h1 className="fw-bold mb-1">Add Product</h1>
                            <p className="text-muted mb-0">
                                Add a new product to your inventory
                            </p>
                        </div>

                        <Link
                            to="/"
                            className="btn btn-outline-dark"
                        >
                            ← Home
                        </Link>
                    </div>

                    {/* Form Card */}
                    <div className="card border-0 shadow-sm">
                        <div className="card-body p-4 p-md-5">

                            <form onSubmit={HandleSubmit}>

                                {/* Product Name */}
                                <div className="mb-3">
                                    <label className="form-label fw-semibold">
                                        Product Name
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        value={productName}
                                        placeholder="Enter product name"
                                        onChange={(e) =>
                                            setProductName(e.target.value)
                                        }
                                    />
                                </div>

                                {/* Description */}
                                <div className="mb-3">
                                    <label className="form-label fw-semibold">
                                        Product Description
                                    </label>
                                    <textarea
                                        className="form-control"
                                        rows={4}
                                        value={productDec}
                                        placeholder="Enter product description"
                                        onChange={(e) =>
                                            setProductDec(e.target.value)
                                        }
                                    />
                                </div>

                                {/* Price + Category */}
                                <div className="row">
                                    <div className="col-md-6 mb-3">
                                        <label className="form-label fw-semibold">
                                            Product Price
                                        </label>
                                        <div className="input-group">
                                            <span className="input-group-text">
                                                ₹
                                            </span>
                                            <input
                                                type="number"
                                                className="form-control"
                                                value={price}
                                                placeholder="0.00"
                                                onChange={(e) =>
                                                    setPrice(e.target.value)
                                                }
                                            />
                                        </div>
                                    </div>

                                    <div className="col-md-6 mb-3">
                                        <label className="form-label fw-semibold">
                                            Category
                                        </label>
                                        <select
                                            className="form-select"
                                            value={category}
                                            onChange={(e) =>
                                                setCategory(e.target.value)
                                            }
                                        >
                                            <option value="cloth">
                                                Cloth
                                            </option>
                                            <option value="mobile">
                                                Mobile
                                            </option>
                                            <option value="laptop">
                                                Laptop
                                            </option>
                                        </select>
                                    </div>
                                </div>

                                {/* Date + Stock */}
                                <div className="row">
                                    <div className="col-md-6 mb-3">
                                        <label className="form-label fw-semibold">
                                            Release Date
                                        </label>
                                        <input
                                            type="date"
                                            className="form-control"
                                            value={date}
                                            onChange={(e) =>
                                                setDate(e.target.value)
                                            }
                                        />
                                    </div>

                                    <div className="col-md-6 mb-3">
                                        <label className="form-label fw-semibold">
                                            Stock Count
                                        </label>
                                        <input
                                            type="number"
                                            className="form-control"
                                            value={stockCount}
                                            placeholder="Enter stock count"
                                            onChange={(e) =>
                                                setStockCount(e.target.value)
                                            }
                                        />
                                    </div>
                                </div>

                                {/* Availability */}
                                <div className="form-check form-switch mb-4">
                                    <input
                                        className="form-check-input"
                                        type="checkbox"
                                        role="switch"
                                        checked={isAvialable}
                                        onChange={(e) =>
                                            setIsAvialable(e.target.checked)
                                        }
                                    />
                                    <label className="form-check-label fw-semibold">
                                        Product Available
                                    </label>
                                </div>

                                {/* Image */}
                                <div className="mb-4">
                                    <label className="form-label fw-semibold">
                                        Product Image
                                    </label>
                                    <input
                                        type="file"
                                        className="form-control"
                                        accept="image/*"
                                        ref={fileInputRef}
                                        onChange={(e) =>
                                            setImage(
                                                e.target.files?.[0] ?? null
                                            )
                                        }
                                    />
                                    <div className="form-text">
                                        Upload a product image.
                                    </div>
                                </div>

                                {/* Buttons */}
                                <div className="d-flex gap-2 pt-2">
                                    <button
                                        type="submit"
                                        className="btn btn-primary px-4"
                                    >
                                        Add Product
                                    </button>

                                    <Link
                                        to="/"
                                        className="btn btn-outline-secondary px-4"
                                    >
                                        Cancel
                                    </Link>
                                </div>

                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
)
}