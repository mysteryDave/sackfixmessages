package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class DerivativeInstrumentPartiesComponent(noDerivativeInstrumentPartiesField:Option[NoDerivativeInstrumentPartiesField]=None,
                                                derivativeInstrumentPartiesGroups: Option[List[DerivativeInstrumentPartiesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDerivativeInstrumentPartiesField.map(_.value).getOrElse(0) != derivativeInstrumentPartiesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDerivativeInstrumentPartiesField.TagId,noDerivativeInstrumentPartiesField.map(_.value).getOrElse(0), derivativeInstrumentPartiesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noDerivativeInstrumentPartiesField.foreach(fmt(b,_))
    derivativeInstrumentPartiesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object DerivativeInstrumentPartiesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DerivativeInstrumentPartiesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoDerivativeInstrumentPartiesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DerivativeInstrumentPartiesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DerivativeInstrumentPartiesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDerivativeInstrumentPartiesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = DerivativeInstrumentPartiesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DerivativeInstrumentPartiesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DerivativeInstrumentPartiesComponent(myFields.get(NoDerivativeInstrumentPartiesField.TagId).flatMap(f=>NoDerivativeInstrumentPartiesField.decode(f)),
        if (nextTagPosLookup.contains(NoDerivativeInstrumentPartiesField.TagId)) DerivativeInstrumentPartiesGroup.decode(flds, nextTagPosLookup(NoDerivativeInstrumentPartiesField.TagId)) else None))
    } else None
  }

    
}
     