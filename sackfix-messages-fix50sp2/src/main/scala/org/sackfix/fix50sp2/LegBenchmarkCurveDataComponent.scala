package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class LegBenchmarkCurveDataComponent(legBenchmarkCurveCurrencyField:Option[LegBenchmarkCurveCurrencyField]=None,
                                          legBenchmarkCurveNameField:Option[LegBenchmarkCurveNameField]=None,
                                          legBenchmarkCurvePointField:Option[LegBenchmarkCurvePointField]=None,
                                          legBenchmarkPriceField:Option[LegBenchmarkPriceField]=None,
                                          legBenchmarkPriceTypeField:Option[LegBenchmarkPriceTypeField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    legBenchmarkCurveCurrencyField.foreach(fmt(b,_))
    legBenchmarkCurveNameField.foreach(fmt(b,_))
    legBenchmarkCurvePointField.foreach(fmt(b,_))
    legBenchmarkPriceField.foreach(fmt(b,_))
    legBenchmarkPriceTypeField.foreach(fmt(b,_))
    b
  }

}
     
object LegBenchmarkCurveDataComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    LegBenchmarkCurveCurrencyField.TagId, LegBenchmarkCurveNameField.TagId, LegBenchmarkCurvePointField.TagId, LegBenchmarkPriceField.TagId, LegBenchmarkPriceTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==LegBenchmarkCurveCurrencyField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[LegBenchmarkCurveDataComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(LegBenchmarkCurveDataComponent(myFields.get(LegBenchmarkCurveCurrencyField.TagId).flatMap(f=>LegBenchmarkCurveCurrencyField.decode(f)),
        myFields.get(LegBenchmarkCurveNameField.TagId).flatMap(f=>LegBenchmarkCurveNameField.decode(f)),
        myFields.get(LegBenchmarkCurvePointField.TagId).flatMap(f=>LegBenchmarkCurvePointField.decode(f)),
        myFields.get(LegBenchmarkPriceField.TagId).flatMap(f=>LegBenchmarkPriceField.decode(f)),
        myFields.get(LegBenchmarkPriceTypeField.TagId).flatMap(f=>LegBenchmarkPriceTypeField.decode(f))))
    } else None
  }

    
}
     