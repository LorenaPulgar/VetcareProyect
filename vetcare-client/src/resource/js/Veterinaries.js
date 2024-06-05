import axios from "axios"

/**
 * @typedef {{ veterinaryId: number, userId: number, name: string, address: string }} Veterinary
 */

/**
 * @return {Promise<Veterinary[]>}
 */
export async function getVeterinaries() {
    try {
        const response = await axios.get('api/v1/veterinary')
        response.data = response.data.map(veterinary => {
            return {
                veterinaryId: veterinary.id,
                userId: veterinary.user.id,
                name: veterinary.user.name,
                address: veterinary.address
            }
        })
        return response.data
    } catch (err) {
        console.error(err)
    }
}