package carrinhoDeCompra;

public class ItemDoCarrinhoDTO {

	private int id;
	private String descricaoDoProduto;
	private double valorUnitario;
	private int quantidade;
	
	public ItemDoCarrinhoDTO(int id, String descricaoDoProduto, double valorUnitario, int quantidade) {
		this.id = id;
		this.descricaoDoProduto = descricaoDoProduto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}
	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoDoProduto = descricaoDoProduto;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoCarrinhoDTO other = (ItemDoCarrinhoDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
