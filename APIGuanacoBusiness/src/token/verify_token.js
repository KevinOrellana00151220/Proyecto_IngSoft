const jwt = require('jsonwebtoken')

// middleware to validate token (rutas protegidas)
const verifytoken = (req, res, next) => {
    const token = req.header('token')
    if (!token) return res.status(401).json({ error: 'Denied Acess' })
    try {
        const verified = jwt.verify(token, process.env.JWT_SECRET || "TOP_SECRET")
        req.user = verified
        next() // continuamos
    } catch (error) {
        res.status(400).json({error: 'Invalid Token'})
    }
}

module.exports = verifytoken;