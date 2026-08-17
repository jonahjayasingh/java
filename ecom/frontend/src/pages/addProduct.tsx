import {  useState } from "react";
import { Link } from "react-router-dom";


export default function AddProduct(){
    let [productName,setProductName] = useState("")
    let [productDec, setProductDec] = useState("")
    let [price, setPrice]  = useState("");
    let [category , setCategory] = useState("cloth");
    let [date,setDate] = useState("");
    let [isAvialable,setIsAvialable] = useState(true);
    let [stockCount, setStockCount] = useState("");
    let [image, setImage] = useState<File | null>(null);


    const HandleSubmit = (e) => {
        e.preventDefault();
        const product = {
            productName,
            productDec,
            price,
            category,
            date,
            isAvialable,
            stockCount,
            image
        }
        console.log(product)
    }

    return(
        <div>
            <h1>addProduct</h1>
            <Link to="/">Home</Link>
            <div>
                <form onSubmit={HandleSubmit}>
                    <label htmlFor="">Product Name</label>
                    <input type="text" value={productName}
                    onChange={(e) => setProductName(e.target.value)}
                    /> <br /> <br />
                    <label htmlFor="">Product Description</label>
                    <input type="text" value={productDec}
                    onChange={(e) => setProductDec(e.target.value)}
                    /> <br /><br />
                    <label htmlFor="">Product Price</label>
                    <input type="number"  value={price}
                    onChange={(e) => setPrice(e.target.value)}
                    /> <br /><br />
                    <label>Category</label>
                    <select name="category" id="" value={category}
                    onChange={(e) => setCategory(e.target.value)}
                    >
                        <option value="cloth">cloth</option>
                        <option value="mobile">mobile</option>
                        <option value="laptop">laptop</option>
                    </select> <br /><br />
                    <label htmlFor="">Date</label>
                    <input type="date" name="" id="" value={date}
                    onChange={(e) => setDate(e.target.value)}
                    /> <br /><br />
                    <label htmlFor="">is Avialable</label>
                    <input type="checkbox" name="" id="" checked={isAvialable}
                    onChange={(e) => setIsAvialable(e.target.checked)}
                    />
                    <label htmlFor="">Stock Count</label>
                    <input type="number" value={stockCount}
                    onChange={(e) => setStockCount(e.target.value)}
                    /> <br /><br />
                    <label htmlFor="">Image</label>
                    <input type="file" 
                    onChange={(e)=> setImage(e.target.files?.[0] ?? null)}
                    /> <br /><br />
                    <input type="submit" value="Submit" />
                    
                    

                </form>
                
            </div>
        </div>
    )
}