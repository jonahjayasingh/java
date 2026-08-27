import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";


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

export default function SingleProduct() {
    const [product, setProduct] = useState<Product | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    const { id } = useParams<{ id: string }>();
    const navigate = useNavigate();

    useEffect(() => {
        const fetchProduct = async () => {
            try {
                setLoading(true);
                setError("");

                const response = await fetch(
                    `http://localhost:8080/productById?id=${id}`
                );

                if (!response.ok) {
                    throw new Error(`HTTP Error: ${response.status}`);
                }

                const data: Product = await response.json();

                console.log("Product:", data);

                setProduct(data);
            } catch (error) {
                console.error("Server Error:", error);
                setError("Unable to load product details.");
            } finally {
                setLoading(false);
            }
        };

        if (id) {
            fetchProduct();
        }
    }, [id]);

    // Loading
    if (loading) {
        return (
            <div className="container py-5">
                <div className="text-center py-5">
                    <div
                        className="spinner-border text-primary"
                        role="status"
                    >
                        <span className="visually-hidden">
                            Loading...
                        </span>
                    </div>

                    <p className="mt-3 text-muted">
                        Loading product...
                    </p>
                </div>
            </div>
        );
    }

    // Error
    if (error) {
        return (
            <div className="container py-5">
                <div className="alert alert-danger text-center">
                    <i className="bi bi-exclamation-triangle-fill me-2"></i>
                    {error}
                </div>
            </div>
        );
    }

    // Product not found
    if (!product) {
        return (
            <div className="container py-5">
                <div className="alert alert-warning text-center">
                    Product not found.
                </div>
            </div>
        );
    }

    return (
        <div className="container py-5">

            {/* Header */}
            <div className="d-flex justify-content-between align-items-center mb-4">

                <div>
                    <h2 className="fw-bold mb-1">
                        Product Details
                    </h2>

                    <p className="text-muted mb-0">
                        View complete product information
                    </p>
                </div>

                <button
                    className="btn btn-outline-secondary"
                    onClick={() => navigate(-1)}
                >
                    <i className="bi bi-arrow-left me-2"></i>
                    Back
                </button>

            </div>

            {/* Product Card */}
            <div className="card border-0 shadow-lg rounded-4 overflow-hidden">

                <div className="row g-0">

                    {/* Image Section */}
                    <div className="col-lg-5 bg-light">

                        <div
                            className="d-flex align-items-center justify-content-center h-100 p-4"
                            style={{ minHeight: "500px" }}
                        >

                            <img
                                src={`data:image/png;base64,${product.image}`}
                                alt={product.productName}
                                className="img-fluid rounded-3"
                                style={{
                                    maxHeight: "450px",
                                    width: "100%",
                                    objectFit: "contain",
                                }}
                            />

                        </div>

                    </div>

                    {/* Details Section */}
                    <div className="col-lg-7">

                        <div className="card-body p-4 p-md-5">

                            {/* Category + Availability */}
                            <div className="d-flex justify-content-between align-items-center mb-3">

                                <span className="badge bg-primary fs-6 px-3 py-2">
                                    <i className="bi bi-tag me-1"></i>
                                    {product.category}
                                </span>

                                {product.isAvialable ? (
                                    <span className="badge bg-success fs-6 px-3 py-2">
                                        <i className="bi bi-check-circle me-1"></i>
                                        Available
                                    </span>
                                ) : (
                                    <span className="badge bg-danger fs-6 px-3 py-2">
                                        <i className="bi bi-x-circle me-1"></i>
                                        Unavailable
                                    </span>
                                )}

                            </div>

                            {/* Product Name */}
                            <h1 className="display-6 fw-bold mb-3">
                                {product.productName}
                            </h1>

                            {/* Description */}
                            <p className="text-muted fs-5 mb-4">
                                {product.productDescription}
                            </p>

                            <hr />

                            {/* Price */}
                            <div className="my-4">

                                <small className="text-muted">
                                    Price
                                </small>

                                <h2 className="text-success fw-bold">
                                    ₹{product.price.toLocaleString("en-IN")}
                                </h2>

                            </div>

                            {/* Product Information */}
                            <div className="row g-3 mb-4">

                                {/* ID */}
                                <div className="col-md-6">
                                    <div className="border rounded-3 p-3 h-100">

                                        <div className="text-muted small">
                                            Product ID
                                        </div>

                                        <div className="fw-bold">
                                            #{product.id}
                                        </div>

                                    </div>
                                </div>

                                {/* Category */}
                                <div className="col-md-6">
                                    <div className="border rounded-3 p-3 h-100">

                                        <div className="text-muted small">
                                            Category
                                        </div>

                                        <div className="fw-bold text-capitalize">
                                            {product.category}
                                        </div>

                                    </div>
                                </div>

                                {/* Release Date */}
                                <div className="col-md-6">
                                    <div className="border rounded-3 p-3 h-100">

                                        <div className="text-muted small">
                                            Release Date
                                        </div>

                                        <div className="fw-bold">
                                            {new Date(
                                                product.releaseDate
                                            ).toLocaleDateString("en-IN", {
                                                day: "2-digit",
                                                month: "long",
                                                year: "numeric",
                                            })}
                                        </div>

                                    </div>
                                </div>

                                {/* Stock */}
                                <div className="col-md-6">
                                    <div className="border rounded-3 p-3 h-100">

                                        <div className="text-muted small">
                                            Stock
                                        </div>

                                        <div className="fw-bold">
                                            {product.stockCount} units
                                        </div>

                                    </div>
                                </div>

                            </div>

                            {/* Availability Message */}
                            {product.isAvialable ? (
                                <div className="alert alert-success">
                                    <i className="bi bi-check-circle-fill me-2"></i>

                                    <strong>
                                        Product Available
                                    </strong>

                                    <div className="small mt-1">
                                        This product is currently available
                                        for purchase.
                                    </div>
                                </div>
                            ) : (
                                <div className="alert alert-danger">
                                    <i className="bi bi-x-circle-fill me-2"></i>

                                    <strong>
                                        Product Unavailable
                                    </strong>

                                    <div className="small mt-1">
                                        This product is currently unavailable
                                        for purchase.
                                    </div>
                                </div>
                            )}

                            {/* Buttons */}
                            <div className="d-flex gap-3 mt-4">

                                <button
                                    className="btn btn-primary btn-lg px-4"
                                    disabled={
                                        !product.isAvialable ||
                                        product.stockCount <= 0
                                    }
                                >
                                    <i className="bi bi-cart-plus me-2"></i>
                                    Add to Cart
                                </button>

                                <button
                                    className="btn btn-outline-secondary btn-lg px-4"
                                    onClick={() => navigate(-1)}
                                >
                                    <i className="bi bi-arrow-left me-2"></i>
                                    Back
                                </button>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>
    );
}