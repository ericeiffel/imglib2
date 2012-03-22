/**
 * Copyright (c) 2009--2012, ImgLib2 developers
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.  Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials
 * provided with the distribution.  Neither the name of the imglib project nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.imglib2;

/**
 * An abstract class that implements the {@link RealLocalizable} interface using
 * an array of doubles to maintain position
 *
 * @author Lee Kamentsky
 * @author Stephan Saalfeld
 * @author Tobias Pietzsch <tobias.pietzsch@gmail.com>
 */
public abstract class AbstractRealLocalizable extends AbstractEuclideanSpace implements RealLocalizable
{
	/**
	 * The {@link RealLocalizable} interface is implemented using the position
	 * stored here. {@link RealPositionable} subclasses, such as {@link RealPoint},
	 * modify this array.
	 */
	protected final double[] position;

	/**
	 * @param n
	 *            number of dimensions.
	 */
	protected AbstractRealLocalizable( final int n )
	{
		super( n );
		position = new double[ n ];
	}

	/**
	 * Protected constructor that re-uses the passed position array. This is
	 * intended to allow subclasses to provide a way to wrap a double[] array.
	 *
	 * @param position
	 *            position array to use.
	 */
	protected AbstractRealLocalizable( final double[] position )
	{
		super( position.length );
		this.position = position;
	}

	@Override
	public void localize( final float[] pos )
	{
		for ( int d = 0; d < n; ++d )
			pos[ d ] = ( float ) position[ d ];
	}

	@Override
	public void localize( final double[] pos )
	{
		for ( int d = 0; d < n; ++d )
			pos[ d ] = position[ d ];
	}

	@Override
	public float getFloatPosition( final int d )
	{
		return ( float ) position[ d ];
	}

	@Override
	public double getDoublePosition( final int d )
	{
		return position[ d ];
	}
}