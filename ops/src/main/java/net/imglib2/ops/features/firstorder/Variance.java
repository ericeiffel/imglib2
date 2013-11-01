package net.imglib2.ops.features.firstorder;

import net.imglib2.ops.features.AbstractFeature;
import net.imglib2.ops.features.RequiredFeature;
import net.imglib2.ops.features.firstorder.moments.Moment2AboutMean;
import net.imglib2.type.numeric.RealType;
import net.imglib2.type.numeric.real.DoubleType;

public class Variance< T extends RealType< T >> extends AbstractFeature< DoubleType >
{
	@RequiredFeature
	Moment2AboutMean< T > moment2;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String name()
	{
		return "Variance";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Variance< T > copy()
	{
		return new Variance< T >();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected DoubleType recompute()
	{
		return new DoubleType( moment2.get().get() );
	}

}