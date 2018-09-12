package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class InstrumentPartiesComponent(noInstrumentPartiesField:Option[NoInstrumentPartiesField]=None,
                                      instrumentPartiesGroups: Option[List[InstrumentPartiesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noInstrumentPartiesField.map(_.value).getOrElse(0) != instrumentPartiesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoInstrumentPartiesField.TagId,noInstrumentPartiesField.map(_.value).getOrElse(0), instrumentPartiesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noInstrumentPartiesField.foreach(fmt(b,_))
    instrumentPartiesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object InstrumentPartiesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentPartiesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoInstrumentPartiesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentPartiesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentPartiesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoInstrumentPartiesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = InstrumentPartiesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrumentPartiesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrumentPartiesComponent(myFields.get(NoInstrumentPartiesField.TagId).flatMap(f=>NoInstrumentPartiesField.decode(f)),
        if (nextTagPosLookup.contains(NoInstrumentPartiesField.TagId)) InstrumentPartiesGroup.decode(flds, nextTagPosLookup(NoInstrumentPartiesField.TagId)) else None))
    } else None
  }

    
}
     