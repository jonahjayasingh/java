import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

interface Product {
    id: number;
    productName: string;
    productDescription: string;
    price: number;
    category: string;
    releaseDate: string;
    isAvialable: boolean;
    stockCount: number;
    image: string;
}

export default function Home(){
    const [products,setProducts]= useState<Product[]>([]);
    const [search,setSearch] = useState("")

    useEffect( ()=>{
        const fetchProducts = async () =>{
            try{
                const response = await fetch("http://localhost:8080/products")
                if (!response.ok){
                    throw new Error("HTTP ERROR : ${response.status}")
                }
                const data =await response.json();
                console.log(data)
                setProducts(data)
            }catch{
                console.log("Server Error")
            }
        }
        fetchProducts()
    },[])

    const handleForm = async (e)=>{
        e.preventDefault();
        console.log(search)
        const formData = new FormData();
        formData.append("query",search)
        try{
                const response = await fetch("http://localhost:8080/search",{
                    method:"POST",
                    body:formData
                })
                if (!response.ok){
                    throw new Error("HTTP ERROR : ${response.status}")
                }
                const data =await response.json();
                console.log(data)
                setProducts(data)
            }catch{
                console.log("Server Error")
            }
    }
    return (
    <div className="bg-light min-vh-100 py-5">
        <div className="container">

            {/* Header */}
            <div className="d-flex flex-column flex-md-row justify-content-between align-items-md-center mb-4">
                <div>
                    <h1 className="fw-bold mb-1">Our Products</h1>
                    <p className="text-muted mb-0">
                        Discover our latest products
                    </p>
                </div>

                <Link
                    to="/addProduct"
                    className="btn btn-primary mt-3 mt-md-0 px-4"
                >
                    + Add Product
                </Link>
            </div>

            {/* Search */}
            <form
                onSubmit={handleForm}
                className="card border-0 shadow-sm p-3 mb-4"
            >
                <div className="row g-2">
                    <div className="col">
                        <input
                            type="text"
                            value={search}
                            onChange={(e) => setSearch(e.target.value)}
                            placeholder="Search products..."
                            className="form-control form-control-lg"
                        />
                    </div>

                    <div className="col-auto">
                        <button
                            type="submit"
                            className="btn btn-dark btn-lg px-4"
                        >
                            Search
                        </button>
                    </div>
                </div>
            </form>

            {/* Products */}
            <div className="row g-4">
                {products.map((product) => (
                    <div
                        className="col-12 col-sm-6 col-lg-4 col-xl-3"
                        key={product.id}
                    >
                        <div className="card h-100 border-0 shadow-sm product-card">

                            {/* Image */}
                            <div
                                className="bg-light overflow-hidden"
                                style={{ height: "220px" }}
                            >
                                <img
                                    src={`data:image/png;base64,${product.image}`}
                                    alt={product.productName}
                                    className="w-100 h-100 object-fit-cover"
                                />
                            </div>

                            {/* Content */}
                            <div className="card-body d-flex flex-column">

                                <div className="d-flex justify-content-between align-items-start mb-2">
                                    <h5 className="card-title fw-bold mb-0">
                                        {product.productName}
                                    </h5>

                                    <span className="badge bg-primary">
                                        {product.category}
                                    </span>
                                </div>

                                <p className="card-text text-muted small">
                                    {product.productDescription}
                                </p>

                                <div className="mt-auto">
                                    <div className="d-flex justify-content-between align-items-center mb-3">
                                        <div>
                                            <small className="text-muted d-block">
                                                Price
                                            </small>
                                            <span className="fs-5 fw-bold">
                                                ₹{product.price}
                                            </span>
                                        </div>

                                        <div className="text-end">
                                            <small className="text-muted d-block">
                                                Stock
                                            </small>

                                            <span
                                                className={
                                                    product.stockCount > 0
                                                        ? "text-success fw-semibold"
                                                        : "text-danger fw-semibold"
                                                }
                                            >
                                                {product.stockCount > 0
                                                    ? `${product.stockCount} available`
                                                    : "Out of stock"}
                                            </span>
                                        </div>
                                    </div>

                                    <button
                                        type="button"
                                        className="btn btn-outline-primary w-100"
                                    >
                                        View Details
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>

            {/* Empty State */}
            {products.length === 0 && (
                <div className="card border-0 shadow-sm text-center py-5 mt-4">
                    <div className="card-body">
                        <h4 className="fw-bold">No products found</h4>
                        <p className="text-muted mb-0">
                            Try adding a new product or searching again.
                        </p>
                    </div>
                </div>
            )}
        </div>
    </div>
)
}