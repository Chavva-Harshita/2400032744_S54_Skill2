import { useState, useEffect, useMemo, useCallback } from 'react';

const FakePostList = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [filter, setFilter] = useState('all');

  const fetchProducts = useCallback(() => {
    setLoading(true);
    setError(null);
    fetch('https://fakestoreapi.com/products')
      .then(response => {
        if (!response.ok) throw new Error('Failed to fetch products');
        return response.json();
      })
      .then(data => {
        setProducts(data);
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  useEffect(() => {
    fetchProducts();
  }, []);

  const categories = useMemo(() => ['all', ...new Set(products.map(p => p.category))], [products]);

  const filteredProducts = useMemo(() => {
    if (filter === 'all') return products;
    return products.filter(p => p.category === filter);
  }, [products, filter]);

  if (loading) return <div className="loading">Loading products...</div>;
  if (error) return <div className="error">Error: {error}</div>;

  return (
    <div className="fake-list">
      <h2>Fake Store Products</h2>
      <div className="controls">
        <button onClick={fetchProducts} className="refresh-btn">Refresh</button>
        <select value={filter} onChange={(e) => setFilter(e.target.value)}>
          {categories.map(cat => (
            <option key={cat} value={cat}>
              {cat === 'all' ? 'All Categories' : cat.charAt(0).toUpperCase() + cat.slice(1)}
            </option>
          ))}
        </select>
      </div>
      <div className="products-grid">
        {filteredProducts.map(product => (
          <div key={product.id} className="product-card">
            <h3>{product.title}</h3>
            <p>{product.description.substring(0, 100)}...</p>
            <p><strong>Price: ${product.price}</strong></p>
            <small>Category: {product.category}</small>
          </div>
        ))}
      </div>
    </div>
  );
};

export default FakePostList;

